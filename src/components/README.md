@ -1,48 +0,0 @@

# SRC Folder

This README exists, so the folder shows up in source control like git. This
file is not needed and can be safely deleted.

However, for completeness, this folder exists for the purpose of storing your
source code. As a reminder, by discipline, this folder must contain at least
four Java files:

1. The Kernel Interface (e.g., `ColorPaletteKernel`)
2. The Enhance Interface (e.g., `ColorPalette`)
3. The Secondary Abstract Class (e.g., `ColorPaletteSecondary`)
4. A Kernel Implementation (e.g., `ColorPalette1`)

Ideally, you will want to package your component appropriately as well.
That means not just dumping your source code in the `src` folder but actually
creating nested folders for grouping similar components. For example, the
`ColorPalette` API can be found in the `src/components/ColorPalette` package.
In other words, you would need to nest a `components` folder in the `src`
folder. Then, nest the `ColorPalette` folder in the `components` folder.
The result would be the following directory structure:

```
src
└───components
    └───ColorPalette
            ColorPalette.java
            ColorPalette1.java
            ColorPaletteKernel.java
            ColorPaletteSecondary.java
```

If done correctly, your portfolio can be bundled as its own `.jar`.
