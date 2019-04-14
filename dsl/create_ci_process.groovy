pipelineJob("ci_process"){
    description('CI job')

	properties {
        githubProjectUrl('https://github.com/pennh/HelloWorld.git/')
    }

	triggers {
        githubPush()
    }	
	
    logRotator {
        numToKeep(80)
    }

    definition {
        cpsScm {
            scm {
                git {
                    branch('master')
                    remote {
                        url('https://github.com/pennh/HelloWorld.git')
						credentials('githubusr')						
                    }
                }
            }
            scriptPath('Jenkinsfile')
        }
    }
}
