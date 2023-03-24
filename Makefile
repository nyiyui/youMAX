ArraysList_Assignment.zip: src/Bridge src/CrazySentences src/MacsBook
	zip -r ArraysList_Assignment.zip src/Bridge src/CrazySentences src/MacsBook

OOP2Airplane_Assignment.zip: src/Airplane
	zip -r $@ $<
