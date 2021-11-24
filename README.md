# Funktionale und objektorientierte Programmierkonzepte

- engl. Functional and object-oriented programming concepts
- Wintersemester 2021/2022
- Präsenzsprechstunde (Presence consultation)

## Disclaimer

- These are supplementary materials that were used during the presence consultation.
- We are not responsible for how the use of these materials affects your exam. So if you get a
  deduction in the exam due to incorrect information in this document, for example, it is not our
  responsibility.
- If you find inconsistencies or mistakes in the materials, please feel free to contact me. Please
  remain factual and write down as precisely as possible where you think the mistake is and how you
  would correct it. I will then try to update the materials in a timely manner.

## Installation

### Compile LaTeX

The custom packages must exist on the TeX path so that the packages can be used.

This can be found with the command:

```sh
kpsewhich -var-value=TEXMFHOME
```

> Under Linux this is usually `~/texmf/tex/latex`

## Usage

The compiled TeX sources can be found in `build/`. You can also compile all LaTeX sources using the
shell script:
- `sh compile.sh`: Compiles missing PDFs in `build/` or changed TeX sources.

Optional arguments:
- `-all`: Compiles all TeX source files
- `[0-9]+`: A number which specifies how often the TeX source should be compiled. Default number
  is 2.

Note that a TeX distribution and the package `tuda-ci` must be available.
