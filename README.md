This is a URL shortening app, hosted on Heroku.

Demo URL: https://miplodder-shortify.herokuapp.com/

## Handy commands

##### Pushing to heroku origin
> git push heroku origin

##### Viewing Server logs
> heroku logs --tail

##### Restarting Heroku
> heroku restart

##### Pods/Dyno Statuses
> heroku ps

##### Controlling Heroku postGres instance
> heroku pg
> heroku pg:psql <heroku-postgres-project-name> -app <project-name>