SHELL := /bin/bash

default: test 

test: main
	mvn test

main: 
	mvn clean
	mvn compile

run: main
	java -cp ./target/classes/ calendar.CalendarMain

jacoco: report
report:
	mvn jacoco:report
	google-chrome target/site/jacoco/index.html

pitest:
	mvn org.pitest:pitest-maven:mutationCoverage
mutate: test pitest  
	set -e ; LOC=$$(ls -t target/pit-reports | head -1) ;\
	google-chrome target/pit-reports/$$LOC/index.html 
