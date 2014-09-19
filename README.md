![Breakout Board](breakout.jpg)

# Screenshot
![Screenshot](screenshot.png)

# Instructions
## Schematic
![Pi Schematic](schematic-pi.jpg)
![ITG3205 Schematic](schematic-itg3205.jpg)

## Wiring
![Wiring](wiring.jpg)

## Computer
* Compile project
  * OS X/Linux: `$ ./gradlew distZip`
  * Windows `gradlew.bat distZip`
* ZIP file will be located in build/distributions
* Copy pi-itg3205.zip to your Raspberry Pi

## Raspberry Pi
```bash
$ unzip pi-itg3205.zip
$ cd pi-itg3205
$ sudo bin/pi-itg3205
```
