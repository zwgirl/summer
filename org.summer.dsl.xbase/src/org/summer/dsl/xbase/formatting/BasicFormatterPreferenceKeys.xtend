package org.summer.dsl.xbase.formatting

class BasicFormatterPreferenceKeys {
	public static val lineSeparator = new org.summer.dsl.xbase.formatting.StringKey("line.separator", System.getProperty("line.separator"))
	public static val indentation = new org.summer.dsl.xbase.formatting.StringKey("indentation", "\t")
	public static val indentationLength = new org.summer.dsl.xbase.formatting.IntegerKey("indentation.length", 4)
	public static val maxLineWidth = new org.summer.dsl.xbase.formatting.IntegerKey("line.width.max", 120)
}

