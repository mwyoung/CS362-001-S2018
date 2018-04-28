.PHONY: test
rmxml=rm -f calendar.xml calendar[0-9].xml

test:
	-$(rmxml)
	mvn clean
	mvn compile
	mvn test

run:
	java -cp ./target/classes/ calendar.CalendarMain

clean:
	-$(rmxml)

report:
	mvn jacoco:report
	google-chrome target/site/jacoco/index.html
