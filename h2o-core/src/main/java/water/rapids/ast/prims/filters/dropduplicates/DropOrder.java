package water.rapids.ast.prims.filters.dropduplicates;

public enum DropOrder {
    DropFirst, // Retain only the last duplicated row
    DropLast // Retain only the first duplicated row
}
