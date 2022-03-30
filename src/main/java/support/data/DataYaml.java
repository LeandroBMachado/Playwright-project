package support.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.IOException;
import java.util.*;


@Log4j2
public class DataYaml {

    private static File getYamlDataFile(String fileName) {
        log.info(String.format("Pegando arquivo %s.yaml com a massa de dados do ambiente %s"
                , fileName, System.getProperty("env")));
        return new File("./src/test/resources/data/" + System.getProperty("env") + "/" + fileName + ".yml");
    }
    @SneakyThrows
    public static LinkedHashMap<String, String> getMapYamlValues(String fileName, String titulo) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        Map<String, Object> maps;
        try {
            maps = (LinkedHashMap<String, Object>) mapper.readValue(getYamlDataFile(fileName), Map.class);
            log.info(String.format("Retornando objeto HashMap com a massa de dados do arquivo %s com titulo %s", fileName, titulo));
            return (LinkedHashMap<String, String>) maps.get(titulo);
        } catch (IOException e) {
            log.error("Erro ao tentar ler o arquivo de massa " + fileName + ".yaml - stackTrace: " + e);
            throw new Exception(e);
        }
    }
    @SneakyThrows
    public static void setMapYamlValues(String fileName, String titulo, Map<String, String> newMaps) {
        try {
            log.info(String.format("Salvando dados no arquivo %s no titulo %s", fileName, titulo));
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            Map<String, Object> mapYml = objectMapper.readValue(getYamlDataFile(fileName),
                    new TypeReference<Map<String, Object>>() {});
            Map<String, Object> maps = (Map<String, Object>) mapYml.get(titulo);
            if (maps == null)
                log.error(String.format("Por favor informar ao menos uma chave abaixo do titulo s% da estrutura dos dados no arquivo s%.yml", titulo, fileName));
            for (Map.Entry<String, String> entry : newMaps.entrySet()) {
                maps.put(entry.getKey(), entry.getValue());
            }
            objectMapper.writeValue(getYamlDataFile(fileName), mapYml);
        } catch (Exception e) {
            log.error("Erro ao tentar salvar dados no arquivo de massa " + fileName + ".yaml - stackTrace: " + e);
        }
    }
    @SneakyThrows
    public static Object yamlToClass(String fileName, String titulo, Class aClass) {
        log.info("Convertendo dados de arquivo yaml para classe em java");
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        Map<String, Object> maps = null;
        try {
            objectMapper.findAndRegisterModules();
            Map<String, Object> mapYml = objectMapper.readValue(getYamlDataFile(fileName),
                    new TypeReference<Map<String, Object>>() {});
            maps = (Map<String, Object>) mapYml.get(titulo);
        } catch (Exception e) {
            log.error("Erro ao tentar converte dados no formato yaml para um objeto - stackTrace: " + e);
        }
        return objectMapper.convertValue(maps, aClass);
    }

}
