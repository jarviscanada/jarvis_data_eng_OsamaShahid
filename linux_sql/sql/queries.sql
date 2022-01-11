select
  cpu_number,
  id,
  total_mem,
  row_number () over (
    partition by cpu_number
    order by
      total_mem
  )
from
  host_info;



select
  hu.host_id,
  hi.hostname,
  date_trunc('hour', hu.timestamp) + date_part('minute', hu.timestamp):: int / 5 * interval '5min' as "timestamp",
  avg(
    (hi.total_mem / 1000) - hu.memory_free
  ) as avg_used_memory_percentage
from
  host_usage hu
  join host_info hi on hu.host_id = hi.id
group by
  hu.host_id,
  hi.hostname,
  hu."timestamp";



with temp1 as (
  select
    host_id,
    date_trunc('hour', timestamp) + date_part('minute', timestamp):: int / 5 * interval '5min' as "timestamp",
    1 as num
  from
    host_usage
)
select
  host_id,
  "timestamp",
  count(num) as num_data_points
from
  temp1
group by
  host_id,
  "timestamp"
having
  count(num) < 5
order by
  "timestamp";