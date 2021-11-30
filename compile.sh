#!/bin/bash

# Optional arguments
compile_all=false
runs=2

# Check all arguments
for arg in "$@"; do
  if [[ $arg =~ [0-9]+ ]]; then
    runs=$arg
  fi
  if [[ $arg == -all ]]; then
    compile_all=true
  fi
done

# Directories
DIR_BASE=$PWD
DIR_DESTINATION="$DIR_BASE/build"

# Files
FILE_NAME="main"
FILE_EXTENSION_INPUT=".tex"
FILE_EXTENSION_OUTPUT=".pdf"
FILE_NAME_INPUT="$FILE_NAME$FILE_EXTENSION_INPUT"

# Paths
PATHS_TEX=$(find "$DIR_BASE" -type f -name "$FILE_NAME_INPUT")
PATHS_CHANGES=$(git diff --name-only "*.tex")

if [ -d "$DIR_DESTINATION" ]; then
  EXISTS_OUTPUT_DIR=true
else
  EXISTS_OUTPUT_DIR=false
fi

# Auxiliaries files
AUXILARIES="log,aux,dvi,lof,lot,bit,idx,glo,bbl,bcf,ilg,toc,ind,out,blg,fdb_latexmk,fls,run.xml,"
AUXILARIES="${AUXILARIES}len,nav,snm,synctex.gz,xmpdata,xmpi"
IFS=, read -ra AUXILARIES <<<"$AUXILARIES"

# Generates an output directory for the compiled eX files.
mkdir -p "$DIR_DESTINATION"

for path in $PATHS_TEX; do
  # Get parent directory
  size=$((${#path} - ${#FILE_NAME_INPUT}))
  parent=${path:0:$size}

  # Change directory to parent directory to reduce conflicts with resources
  cd "$parent" || echo "Could not change directory to $parent" continue
  date="${PWD##*/}"

  generate=false
  pdf="PSS$date$FILE_EXTENSION_OUTPUT"
  output_dir="$DIR_DESTINATION/$pdf"

  # Check if compiling is necessary
  found=$(find "$DIR_BASE" -name "$pdf" | wc -l)
  if [[ $compile_all == true ]] || [[ $EXISTS_OUTPUT_DIR == false ]] ||
    [[ $found -eq 0 ]]; then
    generate=true
  else
    # Check for file changes
    if ! [[ $generate == true ]]; then
      for change in $PATHS_CHANGES; do
        if [[ $path =~ .*$change ]]; then
          generate=true
          break
        fi
      done
    fi
  fi

  # Compile LaTeX and move its output to the destination directory
  if [[ $generate == true ]]; then
    for ((i = 1; i <= runs; i++)); do
      pdflatex.exe -synctex=1 -interaction=nonstopmode "$FILE_NAME_INPUT"
    done
    mv -f "$parent/$FILE_NAME$FILE_EXTENSION_OUTPUT" "$output_dir"
  fi

  cd "$DIR_BASE" || echo "Could not change directory to base directory" exit
done

# Cleanup auxiliaries files
for auxiliary in "${AUXILARIES[@]}"; do
  paths=$(find "$DIR_BASE" -type f -iname "*.$auxiliary")
  for path in $paths; do
    if ! [[ $path =~ .*".git".* ]]; then
      rm "$path"
    fi
  done
done
