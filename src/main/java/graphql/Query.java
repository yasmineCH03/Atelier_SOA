package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Module;
import entities.UniteEnseignement;
import repository.ModuleBusiness;
import repository.UniteEnseignementBusiness;

import java.util.List;


public class Query implements GraphQLRootResolver {
    public static ModuleBusiness mb;
    private UniteEnseignementBusiness ueb;
    public Query(ModuleBusiness mb) {
        this.mb = mb;
    }
    public Query(ModuleBusiness mb,UniteEnseignementBusiness ueb) {
        this.mb = mb;
        this.ueb=ueb;
    }

    public List<Module> getallmodules(){
      return   mb.getAllModules();
    }
    public List<UniteEnseignement> getallUE(){return ueb.getListeUE();}


}
