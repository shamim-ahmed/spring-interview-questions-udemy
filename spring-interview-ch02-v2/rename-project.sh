#!/bin/sh

if [ $# -ne 2 ]
then
  echo "You must pass the source and target directory name, in that order"
  exit 1
fi

CURRENT_NAME=$1
FINAL_NAME=$2

for file in `find . -type d -name $CURRENT_NAME`
do
  dir_loc=`dirname $file`
  mv $file $dir_loc/$FINAL_NAME
done

for file in `find . -type f`
do
  grep $CURRENT_NAME $file > /dev/null
  if [ $? -eq 0 ]
  then
    sed -i "s/$CURRENT_NAME/$FINAL_NAME/g" $file
  fi
done
