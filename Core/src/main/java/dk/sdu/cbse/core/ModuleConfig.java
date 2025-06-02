package dk.sdu.cbse.core;

import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class ModuleConfig {

    public List<IGamePluginService> getGamePluginServices() {
        return load(IGamePluginService.class);
    }

    public List<IEntityProcessingService> getEntityProcessingServices() {
        return load(IEntityProcessingService.class);
    }

    public List<IPostEntityProcessingService> getPostEntityProcessingServices() {
        return load(IPostEntityProcessingService.class);
    }

    private <T> List<T> load(Class<T> service) {
        List<T> list = new ArrayList<>();
        for (T s : ServiceLoader.load(service)) {
            list.add(s);
        }
        return list;
    }

}
