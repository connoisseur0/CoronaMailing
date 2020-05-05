# Setup
## 1. Set properties.xml

Change name example_properties.xml -> properties.xml in root directory.
Change the mail settings value in properties file.

## 2. Set cronetab
### Create start script
 eg startCoronaMailing.sh
 
`java -jar app.jar`
### Add record to cronetab
- open
`EDITOR=nano crontab –e`
- write:
`30 19 * * * /home/app/startCoronaMailing.sh`
- and verify it...
`crontab –l`

Now you can waiting for report... :-)