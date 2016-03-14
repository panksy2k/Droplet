#!/bin/bash

cd ~/ApplicationStack/mongodb/bin
./mongod --dbpath ~/mongo/data --port 27000 --logpath ~/mongo/data/logFile.log &

