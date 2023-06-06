FROM mhbahmani/twitter-likes:base AS LISTENER

CMD ["python3", "listener.py"]

FROM mhbahmani/twitter-likes:base AS HANDLER

CMD ["python3", "events_handler.py"]
