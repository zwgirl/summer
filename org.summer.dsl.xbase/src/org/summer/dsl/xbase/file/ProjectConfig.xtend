package org.summer.dsl.xbase.file

import java.util.Map
import org.summer.ss.lib.macro.file.Path

class ProjectConfig {
	
	@Property val Path rootPath
	@Property val String name
	@Property val Map<Path,Path> sourceFolderMappings = newLinkedHashMap()
	
	new (String name) {
		_name = name
		_rootPath = new Path('''�Path.SEGMENT_SEPARATOR��name�''')
	}
	
	def void addSourceFolderMapping(String from, String to) {
		getSourceFolderMappings.put(getRootPath.append(from), getRootPath.append(to))
	}
}

