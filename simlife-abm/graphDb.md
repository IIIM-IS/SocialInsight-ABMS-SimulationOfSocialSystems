# Using GraphDB to visualize the ontology

GraphDB is a very good tool to not only visualize the ontology but also test out Spark queries. 
SparkQL is the query language used in both GraphDB and Apache Jena to retrieve information from the ontology.

## Set up GraphDB

### Step 1, downloading GraphDB

Go to https://graphdb.ontotext.com/ and download GraphDB.

### Step 2, opening GraphDB

Open GraphDB, it will open up a command window and it will open the DB on the browser. 
If the browser doesn't open, you may open the GraphDB Desktop window and press "Open GraphDB Workbench"
as seen in the following figure:

![GraphdbImage](./imgs/graphdb.png)

### Step 3, creating and connecting a repository

Once the browser window for GraphDB is open you may go to Setup, and then click repositories. 
From then on you should see a button to create Create New Repository as follows:

![GraphdbImage](./imgs/createnewrepo.png)

After pressing it you should select the following option:

![GraphdbImage](./imgs/graphdbrepo.png)

Where you will have to fill the name of the repository, and the options may be left as default. Once your repository has been created, make sure it is running, the icon on the left of the repository name should look green as the following:

![GraphdbImage](./imgs/runrepo.png)

If it doesn't then press the icon that should be green and GraphDB will turn on the repository.

### Step 4, importing ontologies

Once the repository is up and running, to import your ontologies or the ontologies in this repository, you can go to **Import** on the left-hand side of the GraphDB window.

