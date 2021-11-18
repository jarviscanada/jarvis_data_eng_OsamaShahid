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
vmstat_mb=$(vmstat --unit M)


#Retrieve usage specifications
memory_free=$( egrep MemFree /proc/meminfo  |  awk '{print $2 $3}' )
cpu_idle=$(vmstat | awk -F ' ' '{print $15}' | tail -n1)
cpu_kernal=$(vmstat | awk -F ' ' '{print $14}' | tail -n1)
disk_io=$(vmstat -d | awk -F ' ' '{print $10}' | tail -n1)
disk_available=$(df -BM / | awk -F ' ' '{print $4}' | tail -n1)
timestamp=$(date '+%F %T')

#Subquery to find matching id in hot_info table
host_id="(SELECT id FROM host_info WHERE hostname='$hostname')"

# Insert Statement into datanase
insert_stmt="INSERT INTO host_info ( timestamp, host_id, memory_free, cpu_idle, cpu_kernal, disk_io, disk_available) VALUES('$timestamp', '$host_id' ,'$memory_free', '$cpu_idle', '$cpu_kernal', '$disk_io', '$disk_available')"

#set up environment variables
export PGPASSWORD=$psql_password
psql -h $psql_host -p $psql_port -U $psql_user -d $db_name -c "$insert_stmt"
exit 0;
