# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2025.09.19

### Added

- Designed a ColorPalette component
- Designed a DataStream component
- Designed a DataTable component

## [2025.10.16]

### Added

- Designed a proof of concept for ColorPalette component
- Added kernel methods: size, isEmpty, addColor, removeColor
- Added secondary methods: average Color, mostFrequent
- Added ColorToString to display RBG Values
- Added display to show current colors in palette

## [2025.10.25]

### Added

- Designed ColorPaletteKernel and ColorPaletteEnhanced interfaces for the ColorPalette component

### Updated

- Updated project structure to include ColorPaletteKernel.java and ColorPalette.java interface files in src folder

## [2025.11.07]

### Added

- Created ColorPaletteSecondary.java abstract class to implement secondary methods (averageColor, mostFrequent)
- Created ColorPalette1.java concrete class for kernel method implementation
- Added equals(), toString(), and hashCode() methods in ColorPaletteSecondary

### Updated

- Converted ColorPalette.java to an interface containing both kernel and secondary methods
- Reorganized files into components/colorpalette package

### Removed

- Removed ColorPaletteEnhanced.java file

## [2025.11.11]

### Added

- Designed kernel implementation for ColorPalette component
- Implemented all kernel and standard methods in ColorPalette1
- Added constructor and internal createNewRep() method for initialization
- Defined convention and correspondence for internal representation (array of Color objects)

## Updated

- Removed "`" from CHANGELOG
- Removed unnecessary portions in README.md of src folder and updated examples to ColorPalette
