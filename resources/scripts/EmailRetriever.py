import requests
import json
from pymongo import MongoClient


def main():
    collection = connectToMongo("admin", "GEHackathon1")

    refreshMongo(collection)


def refreshMongo(collection):

    for doc in collection.find({}):
        collection.delete_one({'_id': doc['_id']})

    response = requests.get("https://s3rdf9bxgg.execute-api.us-east-2.amazonaws.com/deploy/all")
    response_dict = json.loads(response.text)
    emails = response_dict["data"]

    for email in emails:
        collection.insert_one(email)


def connectToMongo(db_name, collection_name):
    client = MongoClient('localhost', 27017)
    db = client[db_name]
    collection = db[collection_name]
    return collection


if __name__ == '__main__':
    main()