# Identification

- Cours : Utilisation et administration des systèmes informatiques
- Sigle : INF1070
- Session : Hiver 2022
- Groupe : `10`
- Enseignant : `Hugo LeBlanc`
- Auteur : `LOUIS-GABIN` (`NDOL14099600`)

# Section 1

> Question : Quelle est la commande `sed` utilisée pour faire le remplacement de `<codems>` et `<password>` dans le Dockerfile? Inscrivez aussi ici-bas le contenu du fichier que vous donnez comme paramètre à l'option `-f` de cette commande.

```bash
> echo 's/"<codems>"/"$CODEPERM"/' > dockerconfig.sed
> echo 's/"<password>"/INF1070/' >> dockerconfig.sed
> cat dockerconfig.sed
>s/"<codems>"/"$CODEPERM"/
>s/"<password>"/INF1070/
> sed -f dockerconfig.sed Dockerfile_NDOL14099600
```


> Question : Quelle commande pouvez-vous utiliser pour voir la liste de toutes les images Docker de votre machine? Inscrivez cette commande dans votre rapport, ainsi que le texte qu'elle affiche en sortie.

```bash 
> docker images
CONTAINER ID   IMAGE         COMMAND       CREATED          STATUS        PORTS                                                          NAMES

a2c151af605c   image600      "/bin/bash"   10 seconds ago   Created                                                                      container600                      
```

> Question : Quelle commande pouvez-vous utiliser pour voir la liste de tous les containers Docker de votre machine? Inscrivez cette commande ainsi que le texte qu'elle affiche en sortie.

```bash
> docker ps -a

```

> Question : Dans le container, quelle est la sortie de `id CODE_MS` (où `CODE_MS` est votre propre code MS)?

NDOL14099600

> Question : Que contient le répertoire `/inf1070` de votre container? Dans votre container, créez-y un fichier en utilisant `touch`. Êtes-vous capables de supprimer ce fichier à partir de votre machine hôte? Quelle pourrait être l'utilité de ce répertoire?

le repertoire /inf1070 contient les fichiers du images du dockerfile, le script de sauvegarde.sh les packages vim, ouii je suis capable de supprimer ce fichier a partir de la machine hote. ce repertoire est le dossier partager entre le container et la machine hote

> Question : Quelle est la sortie de la commande `lsb_release -a`?

 
```bash 
lsb_release -a

No LSB modules are available.

Distributor ID: Ubuntu

Description: Ubuntu 20.04.4 LTS

Release: 20.04

Codename: focal
```


> Question : Combien de paquets sont installés au total initialement? Combien d'entre eux ont rapport à Python (contient le mot python dans le nom du paquet)? Mettez dans le rapport les deux commandes que vous utilisez pour trouver ces deux nombres.


```bash
> apt list --installed | tail --silent -n +2 |grep -c 'python'

WARNING: apt does not have a stable CLI interface. Use with caution in scripts.

22 #number of lines corresponding to python

```

> Question : Comment afficher dans le container Docker la valeur des variables NOM et CODEPERM telles que décrites dans le fichier `Dockerfile_ABCD01234567`?


```bash 
> echo $NOM $CODEPERM

LOUIS-GABIN NDONGO BODO NDOL14099600
```


# Section 2

> Question : La construction (build) ne fonctionnera pas initialement, car il vous manque un paquet prérequis pour procéder à la compilation. Quelle est la commande requise pour installer le paquet manquant?

```bash 
> cd /opt
> sudo git clone https://github.com/restic/restic
> cd restic
> sudo go run build.go #error, package golang not installed

> export PATH=$PATH:/usr/local/bin/go
> sudo apt update && sudo apt install golang #install package go 
```


> Question : Où pouvez-vous déplacer ce fichier binaire `restic` pour vous assurer de pouvoir utiliser la commande `restic` directement comme une commande du shell? Par exemple, taper `restic --help` devrait montrer l'aide de restic.

```bash 
> mv restic /usr/local/bin #move restic bin file to directory
'/usr/local/bin' #repertory binary file
```

> Question : Quelle est la version de restic? Ajouter au rapport la commande vous permettant de trouver la version, ainsi que le résultat de cette commande.

```bash 
$ restic --help #print restic help
$ restic version
restic 0.13.1 (v0.13.0-80-ge4780d39) compiled with go1.18.1 on linux/amd64
#restic version
```

# Section 3

> Question : Vous ne pouvez pas décompresser le fichier `ntfy.zip` car il vous manque un paquet pour le faire. Installez ce paquet, et ajoutez à votre rapport la commande que vous avez utilisée pour le faire.

```bash 
> sudo apt-get update && sudo apt-get upgrade && sudo apt-get install unzip #install the unzip package
```

> Question : La construction ne fonctionnera pas initialement, car il vous manque un paquet prérequis pour procéd la construction (si vous n'avez pas complété la section précédente, il pourrait vous manquer deux paquets prérequis). Quelle est la commande requise pour installer le(s) paquet(s) manquant(s)?

```bash
> sudo unzip /inf1070/ntfy.zip -d /opt
> sudo apt install make # 
> sudo make build-simple
```

> Question : Quel est le **chemin d'accès absolu** du répertoire contenant le fichier binaire `ntfy` qui a été créé par ces commandes d'installation? (Indice : Vous pouvez utiliser la commande `find` pour trouver ce fichier.)

```bash
"/opt/ntfy-1.16.0/dist/ntfy_linux_amd64/ntfy" #absolute path of ntfy 

```

> Question : Quelle est la version de ntfy?

```bash 
> ntfy  --help
ntfy v1.16.0 (efa6d03), runtime go1.18.1, built at 1650856590

Copyright (C) 2021 Philipp C. Heckel, licensed under Apache License 2.0 & GPLv2
```

> Question : Dans le test de fonctionnalité, quel est le texte affiché par `ntfy sub <nom_sujet>` lorsqu'il y a une nouvelle publication?


```bash 
> echo NDOL14099600 | sha1sum | head -c 6; echo
56b2a1
$ ntfy sub 56b2a1
{"id":"x0sjnMg7LWva","time":1650860076,"event":"message","topic":"56b2a1","message":"Ceci est un test"}
```


# Section 4

> Question : Quelle méthode avez-vous employée pour pouvoir utiliser directement la commande `rclone` comme les autres commandes du shell?

```bash
> cd /opt 
> sudo git clone https://github.com/rclone/rclone.git #install package 
> cd rclone
> sudo go build 
> cp rclone /usr/local/bin/rclone #copy file rclone toward /usr/local/bin/rclone
```


> Question : Quelle est la version de rclone? Ajouter au rapport la commande vous permettant de trouver la version, ainsi que le résultat de cette commande.

```bash
$ rclone version

rclone v1.59.0-DEV #version rclone

- os/version: ubuntu 20.04 (64 bit)

- os/kernel: 5.10.104-linuxkit (x86_64)
```


> Question : Quelle est la sortie de la commande `rclone lsd remote:`?


```bash 
$ rclone lsd remote: #aucun information en sortie
$ rclone ls remote:

1097960 Bienvenue sur MEGA.pdf #file BIENVENUE sur MEGA.pdf in my cloud

299836369 Mrt 3.19 By Tecnical Computer Solutions.rar # RAR file in my cloud
```


# Section 5

> Question : Quelle est la sortie du script `sauvegarde.sh`, si tout s'exécute normalement?

```bash
repository bd36e95b opened successfully, password is correct
lock repository
using parent snapshot 927e2116
load index files
start scan on [/inf1070/backup]
start backup on [/inf1070/backup]
scan finished in 1.811s: 6 files, 3.317 KiB

Files:           0 new,     0 changed,     6 unmodified
Dirs:            0 new,     3 changed,   260 unmodified
Data Blobs:      0 new
Tree Blobs:      3 new
Added to the repo: 2.589 KiB

processed 6 files, 3.317 KiB in 0:01
snapshot f60016b2 saved
```

> Mettez les 2 captures d'écran demandées ici :

Mettre la réponse ici.


# Section 6

> Question : Quelle est la sortie de la commande `crontab -l`?

```bash
> crontab -l
 Edit this file to introduce tasks to be run by cron.

# 

# Each task to run has to be defined through a single line

# indicating with different fields when the task will be run

# and what command to run for the task

# 

# To define the time you can provide concrete values for

# minute (m), hour (h), day of month (dom), month (mon),

# and day of week (dow) or use '*' in these fields (for 'any').

# 

# Notice that tasks will be started based on the cron's system

# daemon's notion of time and timezones.

# 

# Output of the crontab jobs (including errors) is sent through

# email to the user the crontab file belongs to (unless redirected).

# 

# For example, you can run a backup of all your user accounts

# at 5 a.m every week with:

# 0 5 * * 1 tar -zcf /var/backups/home.tgz /home/

# 

# For more information see the manual pages of crontab(5) and cron(8)

# 

# m h  dom mon dow   command

  

#crontab -e  

SHELL=/bin/bash  

MAILTO=bindousalain2014@gmail.com  

PATH=/bin:/sbin:/usr/bin:/usr/sbin:/usr/local/bin:/usr/local/sbin 

HOME=/

#  run-parts

30 03 * * * root /inf1070/sauvegarde.sh
```

# Section 7

> Question : Quelle est la commande `rclone` demandée, ainsi que sa sortie?

```bash 
$ rclone copy /inf1070/backup --verbose /inf1070/cloud

2022/04/25 09:25:23 INFO  : snapshots/5a0c6e3918508892f67b0f1e8e330e1b0f1db3f2a17d689d4f166780bd9aa535: Copied (new)

2022/04/25 09:25:23 INFO  : index/8939f49132c0fa39884207a6bcf99c46b5e89a99dde72c72bad62d98eb221ad2: Copied (new)

2022/04/25 09:25:23 INFO  : keys/f800470e549f0c0475c7d6841e0b8f627dafbd30c35d3bebefe455a696fb06e1: Copied (new)

2022/04/25 09:25:23 INFO  : config: Copied (new)

2022/04/25 09:25:24 INFO  : data/c9/c987b01fdb494a88d0c288a60deaa84898d107693306366b11cddb0560f0bed6: Copied (new)

2022/04/25 09:25:24 INFO  : data/e8/e8e32c38c305d5c8290efbeeb97610865d5755598f62e35b080ce7e205ad8318: Copied (new)

2022/04/25 09:25:24 INFO  : 

Transferred:       3.317 KiB / 3.317 KiB, 100%, 0 B/s, ETA -

Transferred:            6 / 6, 100%

Elapsed time:         1.0s
```

> Question : Quelle est la commande `restic` demandée, ainsi que sa sortie?

```bash 
> restic -r /inf1070/cloud restore latest --target /inf1070/restore 
enter password for repository: 

repository 3dc07fe6 opened successfully, password is correct

restoring <Snapshot 5a0c6e39 of [/inf1070/data] at 2022-04-25 05:54:48.550285479 +0000 UTC by root@a2c151af605c> to /inf1070/restore

```

> Question : Utilisez la commande `diff` pour comparer le répertoire `/inf1070/restore/inf1070/data` avec le répertoire `/inf1070/data`. Que pouvez-vous déduire de l'information (ou de l'absence d'information) que cette commande donne en sortie?




# Section 8

> Étapes d'installation de `pass` depuis la source.

```bash
> sudo apt-get update && sudo apt-get upgrade && sudo apt-get install pass
> pass --help
```

> Question : Quelle est la version de `pass`? Ajoutez au rapport la commande ainsi que sa sortie.

```bash
> pass versiom
============================================

= pass: the standard unix password manager =

=?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  =

=?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  v1.7.3?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  =

=?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  =

= ?|  ?|  ?|  ?|  ?|  ?|  Jason A. Donenfeld ?|  ?|  ?|  ?|  ?|  =

= ?|  ?|  ?|  ?|  ?|  ?|  ?|  Jason@zx2c4.com?|  ?|  ?|  ?|  ?|  ?|  =

=?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  ?|  =

=?|  ?|  ?|  http://www.passwordstore.org/ ?|  ?|  ?|  =

============================================
```

> Question : Quelle commande pouvez-vous utiliser pour ajouter le mot de passe se trouvant dans le fichier `secret` dans une nouvelle entrée de pass, nommée `restic`?

```bash
> restic init --repo /srv/restic-repo > restic 

```
> Question : Avec quelle commande pouvez-vous modifier le mot de passe de l'entrée "restic", dans le gestionnaire de mots de passe `pass`?
```bash 
> pass restic &> /dev/null ~/.bashrc>> ~/.bashrc

```
link vers file_container : 
