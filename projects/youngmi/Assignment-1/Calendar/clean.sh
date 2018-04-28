#!/bin/bash
declare -a filestodelete=("calendar.xml" "calendar2.xml")
for i in "${filestodelete[@]}"; do
	if [ -f "$i" ]; then
		echo "rm $i"
		rm -f "$i"
	fi
done

