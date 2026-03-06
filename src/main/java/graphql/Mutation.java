package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Module;
import entities.UniteEnseignement;
import repository.ModuleBusiness;
import repository.UniteEnseignementBusiness;

public class Mutation implements GraphQLRootResolver {
    private ModuleBusiness mb;
    private UniteEnseignementBusiness ueb;

    public Mutation(ModuleBusiness mb, UniteEnseignementBusiness ueb) {
        this.mb = mb;
        this.ueb = ueb;
    }

    //----------------- CRUD Module ---------------------
    public Boolean addModule(String matricule, String nom, int coefficient, int volumeHoraire, Module.TypeModule type, int codeUE) {
        UniteEnseignement ue = new UniteEnseignement();
        ue.setCode(codeUE);
        Module m = new Module(matricule, nom, coefficient, volumeHoraire, type, ue);
        return mb.addModule(m);
    }

    public Boolean updateModule(String matricule, String nom, int coefficient, int volumeHoraire, Module.TypeModule type, int codeUE) {
        UniteEnseignement ue = new UniteEnseignement();
        ue.setCode(codeUE);
        Module m = new Module(matricule, nom, coefficient, volumeHoraire, type, ue);
        return mb.updateModule(matricule, m);
    }

    public Boolean deleteModule(String matricule) {
        return mb.deleteModule(matricule);
    }

    //----------------- CRUD UE ---------------------
    public Boolean addUE(int code, String domaine, String responsable, int credits, int semestre) {
        UniteEnseignement ue = new UniteEnseignement(code, domaine, responsable, credits, semestre);
        return ueb.addUniteEnseignement(ue);
    }

    public Boolean updateUE(int code, String domaine, String responsable, int credits, int semestre) {
        UniteEnseignement ue = new UniteEnseignement(code, domaine, responsable, credits, semestre);
        return ueb.updateUniteEnseignement(code, ue);
    }

    public Boolean deleteUE(int code) {
        return ueb.deleteUniteEnseignement(code);
    }
}

