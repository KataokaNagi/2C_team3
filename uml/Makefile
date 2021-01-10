# @file     Makefile
# @author   Kataoka Nagi (al18036[at]shibaura-it.ac.jp)
# @brief    Make Diagrams or clean files
# @version  1.0
# @date     2020-12-31 02:45:15

COMPILER := java
GUI_AND_GAMEPROCESS_TARGET := ClassDiagram_GUI_and_GameProess
JDBC_PARENTS_TARGET := ClassDiagram_JDBC_parents
JDBC_CHILDREN_SEARCH_TARGET := ClassDiagram_JDBC_children_search
JDBC_CHILDREN_UPDATE_TARGET := ClassDiagram_JDBC_children_update
JDBC_CONSTS_TARGET := ClassDiagram_JDBC_consts
JAR_FLAGS := -jar plantuml.jar
GRAPHVIZ_FLAGS := -graphvizdot C:\Graphviz\bin\dot.exe
CHARSET_FLAGS := -charset UTF-8

.PHONY: all
all: gui parents search update consts
# java -jar plantuml.jar -graphvizdot C:\Graphviz\bin\dot.exe -charset UTF-8 .\YoutubeAutoComment_ClassDiagram.pu
# java -jar plantuml.jar -graphvizdot C:\Graphviz\bin\dot.exe -charset UTF-8 .\YoutubeAutoComment_SequenceDiagram.pu

.PHONY: gui
gui: $(GUI_AND_GAMEPROCESS_TARGET).png

.PHONY: parents
parents: $(JDBC_PARENTS_TARGET).png

.PHONY: search
search: $(JDBC_CHILDREN_SEARCH_TARGET).png

.PHONY: update
update: $(JDBC_CHILDREN_UPDATE_TARGET).png

.PHONY: consts
consts: $(JDBC_CONSTS_TARGET).png

$(GUI_AND_GAMEPROCESS_TARGET).png: $(GUI_AND_GAMEPROCESS_TARGET).pu
	$(COMPILER) $(JAR_FLAGS) $(GRAPHVIZ_FLAGS) $(CHARSET_FLAGS) $^

$(JDBC_PARENTS_TARGET).png: $(JDBC_PARENTS_TARGET).pu
	$(COMPILER) $(JAR_FLAGS) $(GRAPHVIZ_FLAGS) $(CHARSET_FLAGS) $^

$(JDBC_CHILDREN_SEARCH_TARGET).png: $(JDBC_CHILDREN_SEARCH_TARGET).pu
	$(COMPILER) $(JAR_FLAGS) $(GRAPHVIZ_FLAGS) $(CHARSET_FLAGS) $^

$(JDBC_CHILDREN_UPDATE_TARGET).png: $(JDBC_CHILDREN_UPDATE_TARGET).pu
	$(COMPILER) $(JAR_FLAGS) $(GRAPHVIZ_FLAGS) $(CHARSET_FLAGS) $^

$(JDBC_CONSTS_TARGET).png: $(JDBC_CONSTS_TARGET).pu
	$(COMPILER) $(JAR_FLAGS) $(GRAPHVIZ_FLAGS) $(CHARSET_FLAGS) $^

.PHONY: clean
clean:
	rm -rf .\out\*.png
