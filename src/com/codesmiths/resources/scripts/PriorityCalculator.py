from pymongo import MongoClient
from datetime import *
import re


def main():
    collection = connectToMongo("admin", "GEHackathon1")
    currentDate = date.today()

    for doc in collection.find({}):
        if "priority" not in doc:
            collection.update_one(
                {"_id": doc["_id"]},
                {"$set": {"priority": "low"}}
            )
        else:
            dayDifference = str((datetime.strptime(str(currentDate), '%Y-%m-%d')
                                    - datetime.strptime(doc["sendDate"], '%Y-%m-%d'))).split(",")
            daysUnchecked = re.sub(r"\D", "", dayDifference[0])
            collection.update_one(
                {"_id": doc["_id"]},
                {"$set": {"daysUnchecked": daysUnchecked}}
            )


def connectToMongo(db_name, collection_name):
    client = MongoClient('localhost', 27017)
    db = client[db_name]
    collection = db[collection_name]
    return collection


if __name__ == '__main__':
    main()