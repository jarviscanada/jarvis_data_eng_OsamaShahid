# Linux Cluster Monitoring Agent

## Introduction

We need to manage all of the servers running on a cluster and be able to 
communicate with each linux node. Therefore we need an application that 
allows us to communicate with each server in the cluster through its internal 
IPv4 addresses. The Jarvis team to record each individual computers 
specifications (eg. CPU, Memory Usage, etc.) and store into a Postgre SQL 
database for later access. This application is built using bash scripting to 
retrieve the data and Postgres SQL database. 


## Quick Start


First we need to start a psql instance by starting up dockers and creating
a container if not already created. We have created a script to do all this, 
assuming one is already in the linux_sql directory, and docker is already installed
```shell
# create the docker container with desired username and password
./scripts/psql_docker.sh create|stop|create [db_username][db_password]

# start the psql docker container 
./scripts/psql_docker.sh start

# stop the psql docker container
./scripts/psql_docker.sh stop
```
Once we have the created and are currently running the psql instance we would
want to start the postgres database. 
```shell
# Install postgres cli client 
sudo yum install -y postgresql
# create environment variable
export PGPASSWORD = 'yourpassword'
# connect to database instance 
psql -h HOST_NAME -U USER_NAME -d DB_NAME -W 
```
Now we need to create a database and execute DDL statements to create the 
tables inside. We have already created the schema for database. 
```shell
# execute sql ddl files to create tables
psql -h HOST_NAME -p 5432 -U USER_NAME -d DB_NAME -f ddl.sql
```
We have our database and tables setup and we can now extract data from our 
linux machine by using two scripts we have created. The `host_info.sh` script 
extracts the hardware level information from our machine, while the `host_usage.sh`
gathers the cpu and memory usage. Now to execute these two scripts we use the 
following commands. 

```shell
# Script to run hardware info 
./scripts/host_info.sh psql_host psql_port db_name psql_user psql_password

#example
./scripts/host_info.sh "localhost" 5432 "host_agent" "my_user" "my_password"
```
```shell
# Script to run memory and cpu info 
./scripts/host_usage.sh psql_host psql_port db_name psql_user psql_password

#example
./scripts/host_usage.sh "localhost" 5432 "host_agent" "my_user" "my_password"
```
We gathered and now stored the information in our psql database. However, we
want to continuously keep track of the cpu usage information as this can change 
by the minute. Whereas the hardware information is more static. Therefore, we 
will also implement a crontab job to execute the `host_usage.sh` after each
minute. 

This will execute our `host_usage.sh` every minute and store our logs into 
a temp folder. 
```shell
# type into bash terminal to start crontab
crontab -e

#now inside the crontab type the following
* * * * * /home/centos/dev/jrvs/bootcamp/linux_sql/host_agent/scripts/host_usage.sh 
          localhost 5432 host_agent postgres password > /tmp/host_usage.log
#exit and save

#list of crontab jobs
crontab -l
```

This allows us to extract data by the minute and now we can analyze the machine.
With this information we can determine our servers went offline as there will be gaps
in the dataset. We can also perform analysis on the usage information based on memory. 
This helps us figure out at what times the cpu was overloaded. From the clusters of 
computer running we can determine the time the server went offline and whether it 
had been from over usage.
```shell
# execute sql query file to extract information
psql -h HOST_NAME -p 5432 -U USER_NAME -d DB_NAME -f queries.sql
```


## Implementation
We implemented this project through the use of dockers to create containers and isolate
its environment, bash scripting to automate the task of information extraction 
and postgresql to store into a database.

### Architecture

Insert picture of design

### Scripts

describe the scripts

### Database Modeling

Describe the schema

## Test

testing methods

## Development 

how did we develop app.

## Improvement

