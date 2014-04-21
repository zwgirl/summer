package org.summer.dsl.xbase.file

import java.util.Map

@Data class WorkspaceConfig {
	String absoluteFileSystemPath
	Map<String,org.summer.dsl.xbase.file.ProjectConfig> projects = newLinkedHashMap()
	
	def addProjectConfig(org.summer.dsl.xbase.file.ProjectConfig config) {
		projects.put(config.getName(), config);
	}
	
}
