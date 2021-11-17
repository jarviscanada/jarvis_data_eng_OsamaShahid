#!  /bin/sh

cmd=$1
db_username=$2
db_password=$3

# check dockers status if docker is already running, if not (err code:1) then start docker
sudo systemctl status docker || systemctl start docker

#
container_status= $docker container inspect jrvs-psql

case $cmd in
  create)

    if [ $container_status -eq 0 ]; then
      echo 'Container already created'
      exit 1
    fi

    if  [ $# -ne 3 ]; then
      echo 'Create requires username and password'
      exit 1
    fi

    docker volume create pd_data
    docker run --name jrvs-psql -e POSTGRES_PASSWORD=$db_password -d -v pgdata:/var/lin/postgresql/data -p 5432:5432 postgres:9.6-alpine
    exit 1
    ;;

  start|stop)

    if [ $container_status -eq 1 ]; then
      echo 'Container has not been created'
      exit 1
    fi

    docker container $cmd jrvs-psql
    exit 1
    ;;
  *)
  echo 'Illegal command'
  echo 'Commands: start|stop|create'
  exit 1
  ;;
esac

