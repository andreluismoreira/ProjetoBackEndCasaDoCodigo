## Projeto Back End Casa Do Codigo 
    Estudos de java, Spring, kubernets e Docker

### Projeto de estudos do livro back-end Java da casa do codigo
    - O projeto consiste na crição de uma loja formada por 3 microserviços (Usuario, Produto e Shopping).
    - E utilizando os seguintes frameworks Spring boot, Kubernets e Docker a liguagem de programação e o Java 17 e o banco de dados e PostgreeSQL
   
### Comandos Uteis
#### Atualização de imagem docker em projetos:
    - 1) altera o projeto conforme necessidade.
    - 2) roda comando "mvn clean install" para geração um novo jar.
    - 3) roda o comando "mvn dockerfile:build" para geração de uma nova imagem atualizada.
    - 4) roda o "docker-compose up" que vai subir todo o microserviço.

#### Criação de Dashboards Kubernetes
    - 1) kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.6.1/aio/deploy/recommended.yaml
    - 2) kubectl proxy
    - 3) http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/
    - 4) kubectl create -f create-user.yaml
    - 5) kubectl create token loja-admin --namespace kubernetes-dashboard (loja-admin e o nome usado no create-user.yaml)
    - 6) kubectl delete -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.6.1/aio/deploy/recommended.yaml

#### Principais comandos kubectl:

    - 1) kubectl get (pod|service| deployment)
    - 2) kubectl delete (pod|service| deployment)
    - 3) kubectl create -f <caminho-do-arquivo>/(pod|service| deployment).yaml