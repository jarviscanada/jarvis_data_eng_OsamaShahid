#!  /bin/sh

# Setup arguments (cmd = [create|stop|start])
cmd=$1
db_username=$2
db_password=$3

# check dockers status if docker is already running, if not (err code:1) then start docker
sudo systemctl status docker || systemctl start docker

#checks container status and stores in variable
docker container inspect jrvs-psql
container_status=$?

# Switch statement to handle create|stop|start
case $cmd in
  create)

    # Checks to see if container is already created
    if [ $container_status -eq 0 ]; then
      echo 'Container already created'
      exit 1
    fi

    # Checks for valid number of arguments
    if  [ $# -ne 3 ]; then
      echo 'Create requires username and password'
      exit 1
    fi

    # Created the container
    docker volume create pg_data
    docker run --name jrvs-psql -e POSTGRES_USER=$db_username -e POSTGRES_PASSWORD=$db_password -d -v pgdata:/var/lin/postgresql/data -p 5432:5432 postgres:9.6-alpine
    exit 0
    ;;

  start|stop)
    # Checks if container has already been created
    if [ $container_status -eq 1 ]; then
      echo 'Container has not been created'
      exit 1
    fi

    # Start or Stop container
    docker container $cmd jrvs-psql
    exit 0
    ;;

  *)
  echo 'Illegal command'
  echo 'Commands: start|stop|create'
  exit 1
  ;;
esac

