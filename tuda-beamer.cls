%- Identification -%

% Version
\def\fileversion{1.00}
\def\filedate{2021/11/16}

% Sets the LaTeX version for the package to work.
\NeedsTeXFormat{LaTeX2e}

%- Preconfig -%

%-- LateX 3 Syntax --%
\RequirePackage{expl3}

%-- Color --%
\RequirePackage[table]{xcolor}

% Identification of the class
\ProvidesExplClass{tuda-beamer}
{\filedate}
{\fileversion}
{(TUDa-CI) - Beamer Template}


%- Preconfiguration -%
\LoadClass[
  aspectratio=169,
  authorontitle=true,
  color={accentcolor=3b},
  colorframetitle=false,
  logo=true,
  ngerman,
]{tudabeamer}

% Document color
\newcommand{\documentcolor}{\g_ptxcd_color_accent_tl}

%- Packages -%

%-- Box --%
\RequirePackage{tcolorbox}

%-- Caption --%
% Centering caption
\RequirePackage[justification = centering]{caption}

%-- Code --%
\RequirePackage{code-listings}

%-- Graphics--%
% Relative graphic path
\RequirePackage{graphicx}
\RequirePackage{tikz}
\RequirePackage{memory-block}

%-- Import --%
% Import document content from another direcotry or different document.
\RequirePackage{import}
% Creating standalone documents to add them as sub document to the main document.
\RequirePackage{standalone}

%-- Language --%
\RequirePackage[english, main = ngerman]{babel}
% Quotes
\RequirePackage[babel]{csquotes}

%-- Math --%
\RequirePackage{amsmath, amssymb}
% Bold
\RequirePackage{bm}

%-- Table --%
% beautiful tables
\RequirePackage{booktabs}
% Coloring
\RequirePackage{colortbl}
% Combine rows
\RequirePackage{multirow}

%- Patch -%

% Patching  library in expl3 removing white spaces
\patchcmd
{\pgfutil@InputIfFileExists}
{\input #1}
{%
  \@pushfilename
  \xdef\@currname{#1}%
  \input #1 %
  \@popfilename
}
{}{}

%- Box -%

%-- Note boxes --%
% Custom skins
\tcbuselibrary{skins}

% Dictionary of default tuda colors
\prop_new:N \l__ptxcd_box_color_tuda_prop
\prop_put:Nnn \l__ptxcd_box_color_tuda_prop {tuda-gray} {TUDa-0c}
\prop_put:Nnn \l__ptxcd_box_color_tuda_prop {tuda-blue} {TUDa-2c}
\prop_put:Nnn \l__ptxcd_box_color_tuda_prop {tuda-dgreen} {TUDa-3b}
\prop_put:Nnn \l__ptxcd_box_color_tuda_prop {tuda-lgreen} {TUDa-4c}
\prop_put:Nnn \l__ptxcd_box_color_tuda_prop {tuda-orange} {TUDa-8b}
\prop_put:Nnn \l__ptxcd_box_color_tuda_prop {tuda-red} {TUDa-9b}

% Expand prop item
\cs_generate_variant:Nn \prop_item:Nn { Ne }

% Title of the box
\tl_new:N \l__ptxcd_box_title_tl
% Color of the box
\str_new:N \l__ptxcd_box_color_str

% Box options
% Do not make setting globally visible, only for one environment
\keys_define:nn {ptxcd/notebox}{
  title .code:n=\tl_set:Nn \l__ptxcd_box_title_tl {#1},
  title .default:n=,
  title .initial:n=,
  break .bool_set:N  = \l__ptxcd_box_title_break_bool,
  break .default:n = true,
  break .initial:n  = false,
  color .code:n=\str_set:Nx \l__ptxcd_box_color_str {#1},
  color .default:n=\g_ptxcd_color_accent_tl,
  color .initial:n=\g_ptxcd_color_accent_tl
}

% Note box environment
\DeclareDocumentEnvironment{note}{o}
{
%  Process options
  \IfNoValueF{#1}{\keys_set:nn {ptxcd/notebox}{#1}}
  % Retrieve color
  \str_set:Nx \l__ptxcd_box_color_apply_str {\str_use:N \l__ptxcd_box_color_str}
% Check if the color is a predefined tuda color and retrieve color value
  \prop_if_in:NVT \l__ptxcd_box_color_tuda_prop \l__ptxcd_box_color_apply_str
    {
    % Retrieve color valur from prop
    \str_set:Nx \l__ptxcd_box_color_apply_str {
      \prop_item:Ne \l__ptxcd_box_color_tuda_prop { \str_use:N \l__ptxcd_box_color_apply_str}
    }
  }

% Side note box
  \begin{tcolorbox}
    [
    arc=3pt, % Rounded borders
    boxrule=0pt,
    colback=\l__ptxcd_box_color_apply_str!5,
    enhanced, % Enable customization
    frame\space hidden,
    left=5pt, % Left side margin
    overlay={
      \begin{tcbclipinterior}
        \fill[\l__ptxcd_box_color_apply_str] (frame.south\space west) rectangle
        ([xshift=4pt]frame.north\space west);
      \end{tcbclipinterior}
    }
    ]
    % Print title if it is not empty
    \tl_if_empty:NF \l__ptxcd_box_title_tl {
      \textbf{\tl_use:N \l__ptxcd_box_title_tl}
      % Break line if option is on
      \bool_if:NT \l__ptxcd_box_title_break_bool{
        \\
      }
    }
      }
      {
  \end{tcolorbox}
}

%- Hyperref -%

\hypersetup{
  colorlinks=true,
  linkcolor=black,
  urlcolor=TUDa-2c,
}

%- Paragraph -%

% Indent
\setlength{\parindent}{0pt}

% Linke break
\newcommand{\br}{\vskip .5em}

% Author sep for last author
\providecaptionname{ngerman, german}{\authorsep}{,}
\providecaptionname{english, american, british}{\authorsep}{,}

\seq_new:N \l__ptxcd_author_seq

% Push students to a sequence
\newcommand{\authors}[1]{
% Push author name to the right
  \seq_put_right:Nn \l__ptxcd_author_seq {#1}

% Prepare author convention
  \tl_set:Nx \c__ptxcd_namesr_tl {\seq_item:Nn \l__ptxcd_author_seq {1}}
% Comma separated authors
  \int_step_inline:nn {\seq_count:N \l__ptxcd_author_seq - 2}  {
    \tl_set:Nx \c__ptxcd_namesr_tl {
      \tl_use:N \c__ptxcd_namesr_tl, \space
      \seq_item:Nn \l__ptxcd_author_seq {\int_eval:n {##1 + 1}}
    }
  }
% Last author will be separated with "and"
  \int_compare:nNnTF {\seq_count:N \l__ptxcd_author_seq} > {1}
% If more than two author exists, add an "and, else do nothing
    {
    \tl_set:Nx \c__ptxcd_namesr_tl {
      \tl_use:N \c__ptxcd_namesr_tl
      \authorsep\space
      \seq_item:Nn \l__ptxcd_author_seq {\seq_count:N \l__ptxcd_author_seq}
    }
  }{}
% Set authors
  \author{\tl_use:N \c__ptxcd_namesr_tl}
}

%- Additional configurations -%

\title{Funktionale~und~objektorientierte~Programmierkonzepte}
\subtitle{Präsenz-Sprechstunde~B}
\department{Informatik}
\institute[Algorithmik]{}
