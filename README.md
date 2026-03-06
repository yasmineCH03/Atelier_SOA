# Workshop GraphQL - Guide de Test Postman

Ce document fournit les corps de requête GraphQL pour tester l'API via Postman.
L'URL de l'endpoint est généralement : `http://localhost:8081/WorkshopGraphQL_war_exploded/graphql` (à adapter selon votre configuration).

## 1. Requêtes (Queries)

### Récupérer tous les modules
```graphql
query {
  getallmodules {
    matricule
    nom
    coefficient
    volumeHoraire
    type
    uniteEnseignement {
      code
      domaine
    }
  }
}
```

### Récupérer toutes les Unités d'Enseignement (UE)
```graphql
query {
  getallUE {
    code
    domaine
    responsable
    credits
    semestre
  }
}
```

### Récupérer un module par matricule
```graphql
query {
  getModuleByMatricule(matricule: "M101") {
    nom
    coefficient
    uniteEnseignement {
      domaine
    }
  }
}
```

### Récupérer les modules par type
```graphql
query {
  getModulesByType(type: PROFESSIONNEL) {
    matricule
    nom
  }
}
```

### Récupérer les modules d'une UE spécifique
```graphql
query {
  getModulesByUE(codeUE: 1) {
    nom
    volumeHoraire
  }
}
```

### Récupérer les UE par domaine
```graphql
query {
  getUEByDomaine(domaine: "Informatique") {
    code
    responsable
  }
}
```

### Récupérer les UE par semestre
```graphql
query {
  getUEBySemestre(semestre: 1) {
    code
    domaine
  }
}
```

## 2. Mutations

### Ajouter un module
```graphql
mutation {
  addModule(
    matricule: "M301",
    nom: "GraphQL Advanced",
    coefficient: 2,
    volumeHoraire: 24,
    type: PROFESSIONNEL,
    codeUE: 1
  )
}
```

### Mettre à jour un module
```graphql
mutation {
  updateModule(
    matricule: "M301",
    nom: "GraphQL Master",
    coefficient: 3,
    volumeHoraire: 30,
    type: PROFESSIONNEL,
    codeUE: 1
  )
}
```

### Supprimer un module
```graphql
mutation {
  deleteModule(matricule: "M301")
}
```

### Ajouter une Unité d'Enseignement (UE)
```graphql
mutation {
  addUE(
    code: 6,
    domaine: "Sécurité",
    responsable: "M. Ahmed",
    credits: 4,
    semestre: 2
  )
}
```

### Mettre à jour une UE
```graphql
mutation {
  updateUE(
    code: 6,
    domaine: "Cybersécurité",
    responsable: "M. Ahmed Ali",
    credits: 5,
    semestre: 2
  )
}
```

### Supprimer une UE
```graphql
mutation {
  deleteUE(code: 6)
}
```
