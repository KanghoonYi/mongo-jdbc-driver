package com.dbschema.mongo;

import java.sql.DriverPropertyInfo;
import java.util.ArrayList;

public class DriverPropertyInfoHelper {
  public static final String UUID_REPRESENTATION = "uuidRepresentation";
  public static final String UUID_REPRESENTATION_DEFAULT = "standard";
  public static final String[] UUID_REPRESENTATION_CHOICES = new String[]{"standard", "javaLegacy", "csharpLegacy", "pythonLegacy"};
  public static final String SERVER_SELECTION_TIMEOUT = "serverSelectionTimeoutMS";
  public static final String SERVER_SELECTION_TIMEOUT_DEFAULT = "10000";
  public static final String CONNECT_TIMEOUT = "connectTimeoutMS";
  public static final String CONNECT_TIMEOUT_DEFAULT = "10000";
  public static final String FETCH_DOCUMENTS_FOR_METAINFO = "fetch_documents_for_metainfo";
  public static final int FETCH_DOCUMENTS_FOR_METAINFO_DEFAULT = 10;
  public static final String USE_ES6 = "use_ecmascript_6";
  public static final boolean USE_ES6_DEFAULT = true;
  public static final String MAX_POOL_SIZE = "max_connection_pool_size";
  public static final int MAX_POOL_SIZE_DEFAULT = 3;
  private static final String GET_MAX_SIZE_DOCS = "https://mongodb.github.io/mongo-java-driver/3.6/javadoc/com/mongodb/connection/ConnectionPoolSettings.html#getMaxSize--";
  public static final String SCRIPT_ENGINE = "script_engine";
  public static final String MONGOSH_SCRIPT_ENGINE = "mongosh";
  public static final String NASHORN_SCRIPT_ENGINE = "nashorn";
  public static final String DEFAULT_SCRIPT_ENGINE = MONGOSH_SCRIPT_ENGINE;


  public DriverPropertyInfo[] getPropertyInfo() {
    ArrayList<DriverPropertyInfo> propInfos = new ArrayList<>();

    addPropInfo(propInfos, UUID_REPRESENTATION, UUID_REPRESENTATION_DEFAULT, "UUID representation defines how UUIDs are decoded and encoded.\n" +
            "'standard' - newly created UUIDs are encoded using binary subtype 4. All UUIDs of subtype 3 are shown as raw binary values without decoding to UUID.\n" +
            "'javaLegacy', 'csharpLegacy', 'pythonLegacy' - newly created UUIDs are encoded using corresponding legacy format (subtype 3). UUIDs of subtype 3 are decoded using corresponding legacy format despite of their actual format. UUIDs of subtype 4 are decoded using 'standard' format.",
        UUID_REPRESENTATION_CHOICES);

    addPropInfo(propInfos, SERVER_SELECTION_TIMEOUT, SERVER_SELECTION_TIMEOUT_DEFAULT, "How long the driver will wait for server selection to succeed before throwing an exception.", null);
    addPropInfo(propInfos, CONNECT_TIMEOUT, CONNECT_TIMEOUT_DEFAULT, "How long a connection can take to be opened before timing out.", null);

    addPropInfo(propInfos, FETCH_DOCUMENTS_FOR_METAINFO, Integer.toString(FETCH_DOCUMENTS_FOR_METAINFO_DEFAULT), "Number of documents that will be fetched per collection in order " +
        "to return meta information from DatabaseMetaData.getColumns method.", null);

    addPropInfo(propInfos, USE_ES6, Boolean.toString(USE_ES6_DEFAULT), "Start Nashorn script engine with ecmascript 6 standard", null);
    addPropInfo(propInfos, SCRIPT_ENGINE, DEFAULT_SCRIPT_ENGINE, "Script engine that is used to evaluate mongo shell scripts",
        new String[]{MONGOSH_SCRIPT_ENGINE, NASHORN_SCRIPT_ENGINE});

    addPropInfo(propInfos, MAX_POOL_SIZE, Integer.toString(MAX_POOL_SIZE_DEFAULT), "MongoDB connections pool size per one connection from IDE. See " + GET_MAX_SIZE_DOCS, null);

    return propInfos.toArray(new DriverPropertyInfo[0]);
  }

  private void addPropInfo(final ArrayList<DriverPropertyInfo> propInfos, final String propName,
                           final String defaultVal, final String description, final String[] choices) {
    DriverPropertyInfo newProp = new DriverPropertyInfo(propName, defaultVal);
    newProp.description = description;
    if (choices != null) {
      newProp.choices = choices;
    }
    propInfos.add(newProp);
  }
}
