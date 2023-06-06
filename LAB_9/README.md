How to setup

``` 
docker build -t mhbahmani/twtitter-likes:base -f Dockerfile-Base .
docker build -t mhbahmani/twtitter-likes:listener -t LISTENER .
docker build -t mhbahmani/twtitter-likes:handler -t HANDLER .
```
