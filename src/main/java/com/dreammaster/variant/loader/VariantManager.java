package com.dreammaster.variant.loader;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dreammaster.variant.api.GameVariant;
import com.dreammaster.variant.api.IFullGameVariant;
import com.dreammaster.variant.api.IGameVariant;
import com.google.common.collect.ImmutableList;

import cpw.mods.fml.common.discovery.ASMDataTable;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerAboutToStartEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppedEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;

public final class VariantManager {

    private static final VariantManager INSTANCE = new VariantManager();

    private final Object2ObjectMap<String, IGameVariant> allVariants = new Object2ObjectOpenHashMap<>();
    private final Object2ObjectMap<String, IFullGameVariant> fullVariants = new Object2ObjectOpenHashMap<>();

    private final ObjectList<IGameVariant> loadedVariants = new ObjectArrayList<>();

    private final Logger logger = LogManager.getLogger("GTNH Variant Manager");

    private VariantManager() {}

    public static VariantManager getInstance() {
        return INSTANCE;
    }

    public void setup(ASMDataTable table) {
        gatherAllVariants(table);
    }

    private void gatherAllVariants(ASMDataTable table) {
        Set<ASMDataTable.ASMData> dataSet = table.getAll(GameVariant.class.getCanonicalName());
        List<IGameVariant> instances = new ArrayList<>();
        for (ASMDataTable.ASMData data : dataSet) {
            String variantId = (String) data.getAnnotationInfo().get("variantId");
            try {
                Class<?> clazz = Class.forName(data.getClassName());
                instances.add((IGameVariant) clazz.newInstance());
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                logger.error("Could not initialize variant " + variantId, e);
            }
        }
        instances.stream().sorted((v1, v2) -> {
            GameVariant v1a = v1.getClass().getAnnotation(GameVariant.class);
            GameVariant v2a = v2.getClass().getAnnotation(GameVariant.class);
            return v1a.variantId().compareTo(v2a.variantId());
        }).forEachOrdered(v -> allVariants.put(v.getClass().getAnnotation(GameVariant.class).variantId(), v));
        for (var entry : allVariants.entrySet()) {
            if (entry.getValue() instanceof IFullGameVariant fullVariant) {
                fullVariants.put(entry.getKey(), fullVariant);
            }
        }
    }

    public void onConstruction(FMLConstructionEvent event) {
        for (IGameVariant variant : loadedVariants) {
            if (variant instanceof IFullGameVariant fullVariant) {
                fullVariant.getLogger().debug("Construction start");
                fullVariant.construction(event);
                fullVariant.getLogger().debug("Construction end");
            }
        }
    }

    public void onPreInit(FMLPreInitializationEvent event) {
        // Separate loops for strict ordering
        for (IGameVariant variant : loadedVariants) {
            if (variant instanceof IFullGameVariant fullVariant) {
                fullVariant.getLogger().debug("Registering packets");
                fullVariant.registerPackets();
            }
        }
        for (IGameVariant variant : loadedVariants) {
            if (variant instanceof IFullGameVariant fullVariant) {
                fullVariant.getLogger().debug("Pre-init start");
                fullVariant.preInit(event);
                fullVariant.getLogger().debug("Pre-init end");
            }
        }
    }

    public void onInit(FMLInitializationEvent event) {
        for (IGameVariant variant : loadedVariants) {
            if (variant instanceof IFullGameVariant fullVariant) {
                fullVariant.getLogger().debug("Init start");
                fullVariant.init(event);
                fullVariant.getLogger().debug("Init end");
            }
        }
    }

    public void onPostInit(FMLPostInitializationEvent event) {
        for (IGameVariant variant : loadedVariants) {
            if (variant instanceof IFullGameVariant fullVariant) {
                fullVariant.getLogger().debug("Post-init start");
                fullVariant.postInit(event);
                fullVariant.getLogger().debug("Post-init end");
            }
        }
    }

    public void onLoadComplete(FMLLoadCompleteEvent event) {
        for (IGameVariant variant : loadedVariants) {
            if (variant instanceof IFullGameVariant fullVariant) {
                fullVariant.getLogger().debug("Load-complete start");
                fullVariant.loadComplete(event);
                fullVariant.getLogger().debug("Load-complete end");
            }
        }
    }

    public void onServerAboutToStart(FMLServerAboutToStartEvent event) {
        for (IGameVariant variant : loadedVariants) {
            if (variant instanceof IFullGameVariant fullVariant) {
                fullVariant.getLogger().debug("Server-about-to-start start");
                fullVariant.serverAboutToStart(event);
                fullVariant.getLogger().debug("Server-about-to-start end");
            }
        }
    }

    public void onServerStarting(FMLServerStartingEvent event) {
        for (IGameVariant variant : loadedVariants) {
            if (variant instanceof IFullGameVariant fullVariant) {
                fullVariant.getLogger().debug("Server-starting start");
                fullVariant.serverStarting(event);
                fullVariant.getLogger().debug("Server-starting end");
            }
        }
    }

    public void onServerStarted(FMLServerStartedEvent event) {
        for (IGameVariant variant : loadedVariants) {
            if (variant instanceof IFullGameVariant fullVariant) {
                fullVariant.getLogger().debug("Server-started start");
                fullVariant.serverStarted(event);
                fullVariant.getLogger().debug("Server-started end");
            }
        }
    }

    public void onServerStopping(FMLServerStoppingEvent event) {
        for (IGameVariant variant : loadedVariants) {
            if (variant instanceof IFullGameVariant fullVariant) {
                fullVariant.getLogger().debug("Server-stopping start");
                fullVariant.serverStopping(event);
                fullVariant.getLogger().debug("Server-stopping end");
            }
        }
    }

    public void onServerStopped(FMLServerStoppedEvent event) {
        for (IGameVariant variant : loadedVariants) {
            if (variant instanceof IFullGameVariant fullVariant) {
                fullVariant.getLogger().debug("Server-stopped start");
                fullVariant.serverStopped(event);
                fullVariant.getLogger().debug("Server-stopped end");
            }
        }
    }

    public void processIMC(ImmutableList<FMLInterModComms.IMCMessage> messages) {
        for (FMLInterModComms.IMCMessage message : messages) {
            for (IGameVariant variant : loadedVariants) {
                if (variant instanceof IFullGameVariant fullVariant) {
                    if (fullVariant.processIMC(message)) {
                        break;
                    }
                }
            }
        }
    }
}
