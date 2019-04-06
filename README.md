# Projet PokeQuest

### A- Description du projet

Le projet PokeQuest est un projet personnel pour repondre aux attentes de notre formation en DUT Informatique  

Ce projet est une application Android plus particulièrement un jeu où l'on doit trouver un Pokemon via plusieurs indices.

### B- Liste des développeurs

- Jerome BIZOT
- Valentin CIZEAU

### C- La norme flow

La norme flow fonctionne en plusieurs étape :

- Cloner le projet
- Creer une branche pour votre nouvelle fonctionnalité
- Faites un pull request via gitlab
- En parler via notre serveur discord
- Attendre que nous faisions le necessaire

### D- Comment utiliser la norme FLOW ?

La norme FLOW est basé sur le fonctionnement du logiciel git-flow. Il fonctionne sur le principe de creer une branche lors de l'ajout d'une fonctionnalité. Ce qui permet de séparer chaque ajout de fonctionnalité et donc d'une meilleure gestion des conflits entre les branches.

Dans le git on trouvera deux branches principales, une "master" une "develop".
- master sera utiliser lors de la sortie d'une nouvelle version (Alpha, Beta, V1, V2, ...)
- develop sera la branche où chaqu'un fera un "merge request" de leur branche.
  
Un "merge request" est une fonctionnalité de GitLab permettant de demander l'autorisation aux administrateur du GIT si oui ou non on autorise la fusion de votre branche au develop.

#### 1- Creation d'une branche

    git branch nomDeMaFonctionnalite

#### 2- Changement de branche

    git checkout nomBranche

#### 3- Verification de la branche où on est

    git status

#### 4- Récuperation des modifications

    git add .

#### 5- Realisation d'un commit
Un commit doit être sous la forme de ceci : 

    {feat | refact | bugfix | style}{(nomFichier)}:{description}

Où :
- feat désigne l'ajout d'une fonctionnalité
- refact désigne la modification d'un code sans réel conséquence
- bugfix désigne la correction d'un bug
- style désigne l'amélioreration de l'estétique

#### 6- Commit

    git commit -m "feat (fichier) : développement de la partie inscription"

#### 7- Envoie du commit

    git push origin nomDeLaBranche

#### 8- Envoie d'un merge request

Allez sur le site web de GitLab ainsi que dans le projet.
Faites :
- clique sur Demande de fusion
- New "merge request"
- Dans "source branch" selectionner votre branche
- Dans "targer branch" selectionnez develop
- Cliquez sur "compare branch and continue"
- Les champs sont facultatifs donc descendez et cliquez sur le bouton "submit demande de fusion"
  
#### 9- Supprimer la branche en locale

    git branch -D nomDeLaBranche

### E- Logiciels utilisés

- VSCode
- GIT
- Android Studio
