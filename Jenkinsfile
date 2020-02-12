pipeline{
stages {
stage('docker compose') 
{
  steps {sh 'sudo docker-compose build'
sh 'sudo docker-compose up -d'
}
}
}
}
