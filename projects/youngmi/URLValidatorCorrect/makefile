SHELL := /bin/bash

default: test 

test: clean main
	mvn test

main: 
	mvn clean
	mvn compile

run: main
	java -cp ./target/classes/ calendar.CalendarMain

report:
	mvn jacoco:report
	google-chrome target/site/jacoco/index.html

mutate: test   
	mvn org.pitest:pitest-maven:mutationCoverage
	set -e ;\
	LOC=$$(ls -t target/pit-reports | head -1) ;\
	google-chrome target/pit-reports/$$LOC/index.html 
