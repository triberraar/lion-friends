# lion-friends [![Travis build status](https://img.shields.io/travis/triberraar/lion-friends/develop.svg)](https://travis-ci.org/triberraar/lion-friends)
## How to build
There are two build processes: one for the frontend and one for the backend. As all the resources are packaged in the jar (html and javascript), you should rund the frontend build before the backend one.
You can also optionally build a docker image.

Both the frontend and backend are also build on TravisCI (see .travis.yml) and have test coverage reports, see this readme.
### Requirements
Node, maven should be installed. Chrome is optional but is used in the unit tests. The application is also only tested on chrome, but any evergreen browser should do.
### Frontend
The frontend is javascript based and the build system is plain npm. There are 3 scripts for the build: install, lint(optional) and test_chrome(optional). To run the scripts us npm run <script>.

install: Will install all dependencies. It also installs a local copy of bower and then installs all the bower dependencies. This is all that is needed to build the frontend. See package.json and bower.json.

lint: Uses eslint to lint the code and check the codestyle. It uses both the recommended rules and angular specific rules. See the .eslintrc file.

test_chrome: Runs the unit tests of the frontend with help of karma. See the karma.conf.js file.
### Backend
The build system is based on maven. This both builds and tests the code. To run maven use 'mvn clean install'.

### Docker
A docker file is provided to build the docker image use 'docker build -t lion-friends .' (mind the dot at the end). The docker file exposes one port 8080.

## How to run
The application can both be run as a java application or a docker based application.
### Java
Simply run 'java -jar target/lion-friends-0.0.1-SNAPSHOT.jar'. This will startup the embedded tomcat container. The application is serverd at localhost:8080.
### Docker
To run with docker, first build the image and then run 'docker run -p 8080:8080 lion-friends' (other port mappings are off course also valid). The applicaiton is then served on localhost:8080, unless a virutal machine is used (as on osX) then it is server on <virtual ip>:8080.
## Backend [![Codecov test coverage](https://img.shields.io/codecov/c/github/triberraar/lion-friends/develop.svg)](https://codecov.io/github/triberraar/lion-friends?branch=develop)
## Frontend [![Coveralls test coverage](https://img.shields.io/coveralls/triberraar/lion-friends/develop.svg)](https://coveralls.io/github/triberraar/lion-friends?branch=develop)