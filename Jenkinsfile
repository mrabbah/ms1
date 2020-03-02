pipeline {
  agent any
  stages {

	stage('Build, Tag and Push Docker Images For keycloak-db') {
		steps{
			step([$class: 'DockerBuilderPublisher', 
				  cleanImages: false, 
				  cleanupWithJenkinsJobDelete: false, 
				  cloud: 'docker', 
				  dockerFileDirectory: './mysql', 
				  pushCredentialsId: 'sal-images-deployer', 
				  pushOnSuccess: true, 
				  tagsString: 'sal-container-registry.k8s-dev.iamdg.net.ma/keycloak-db:latest']
				  )
		}
	}
	

	stage('Build, Tag and Push Docker Images For keycloak-core') {
		steps{
			step([$class: 'DockerBuilderPublisher', 
				  cleanImages: false, 
				  cleanupWithJenkinsJobDelete: false, 
				  cloud: 'docker', 
				  dockerFileDirectory: '.', 
				  pushCredentialsId: 'sal-images-deployer', 
				  pushOnSuccess: true, 
				  tagsString: 'sal-container-registry.k8s-dev.iamdg.net.ma/keycloak-core:latest']
				  )
		}
	}
	
	stage('Deploy to k8s cluster') {
		steps {
			withKubeConfig([credentialsId: 'sal-k8s',
				serverUrl: 'https://10.80.246.11:6443',
				contextName: 'sal-keycloak',
				clusterName: 'k8s-digi-dev.devops',
				namespace: 'sal-keycloak'
			]) {

				script {
					try {
						sh 'kubectl apply -f k8s-config/sal-keycloak-db.yaml'

					} catch (error) {
						sh 'kubectl create -f k8s-config/sal-keycloak-db.yaml'
					}
					try {
						sh 'kubectl apply -f k8s-config/sal-keycloak-core.yaml'

					} catch (error) {
						sh 'kubectl create -f k8s-config/sal-keycloak-core.yaml'
					}
					try {
						sh 'kubectl apply -f k8s-config/sal-keycloak-ingress.yaml'

					} catch (error) {
						sh 'kubectl create -f k8s-config/sal-keycloak-ingress.yaml'
					}
				}


			}
		}
   }
  }

}
