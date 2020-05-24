Jmeter Test Plans -

1) First one energymart_plan_recommend_view_result.jmx needs to be run using jmeter only to check if everything is working as expected.
2) Second one energymart_plan_recommend_command_line.jmx needs to be run from command line.

command -
  sh jmeter.sh -n -t /Users/rahulbhargava/Desktop/git_repo/java/java-performance-tuning/jmeter/energymart_plan_recommend_command_line.jmx -l /Users/rahulbhargava/Desktop/git_repo/java/java-performance-tuning/jmeter/energymart.jtl -Jthreads=100 -Jduration=120

  sh jmeter.sh -g /Users/rahulbhargava/Desktop/git_repo/java/java-performance-tuning/jmeter/energymart.jtl -o /Users/rahulbhargava/Desktop/git_repo/java/java-performance-tuning/jmeter/html-report
