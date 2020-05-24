# Jmeter Test Plans -

- energymart_plan_recommend_view_result.jmx needs to be run using jmeter only to check if everything is working as expected.
- energymart_plan_recommend_command_line.jmx needs to be run from command line.

alias jmeter='/Users/rahulbhargava/Library/jmeter/bin/jmeter.sh'

command -
  jmeter -n -t energymart_plan_recommend_command_line.jmx -l energymart.jtl -Jthreads=100 -Jduration=120

  jmeter -g energymart.jtl -o html-report
