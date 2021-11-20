#! /bin/sh

# Setup Arguments
psql_host=$1
psql_port=$2
db_name=$3
psql_user=$4
psql_password=$5


# Check number of arguments
if [ $# -ne 5 ]; then
  echo 'Please enter valid number of arguments'
  exit 1
  fi

#Host store into variables
lscpu_out=`lscpu`
vmstat_mb=$(vmstat --unit M)
hostname=$(hostname -f)


#Retrieve hardware specifications
cpu_number=$(echo "$lscpu_out"  | egrep "^CPU\(s\):" | awk '{print $2}' | xargs)
cpu_architecture=$(echo "$lscpu_out"  | egrep "^Architecture:"  | awk '{print $2}'  | xargs)
cpu_model=$(echo "$lscpu_out" | egrep "Model name:" | awk '{print $3 $4 $5 $6 $7}' | xargs)
cpu_mhz=$(echo "$lscpu_out" | egrep "CPU MHz:" | awk '{print $3}' | xargs)
l2_cache=$(echo "$lscpu_out" | egrep "L2 cache:" | awk '{print $3}' | sed 's/[^0-9]*//g' | xargs)
total_mem=$( egrep MemTotal /proc/meminfo  |  awk '{print $2 $3}' | sed 's/[^0-9]*//g' | xargs)
timestamp=$(date '+%F %T')


# Insert Statement into datanase
insert_stmt="INSERT INTO host_info ( hostname, cpu_number, cpu_architecture, cpu_model, cpu_mhz, l2_cache, total_mem, timestamp) VALUES('$hostname', '$cpu_number' ,'$cpu_architecture', '$cpu_model', '$cpu_mhz', '$l2_cache', '$total_mem', '$timestamp' )"


#set up environment variables
export PGPASSWORD=$psql_password
psql -h $psql_host -p $psql_port -U $psql_user -d $db_name -c "$insert_stmt"
exit 0;

