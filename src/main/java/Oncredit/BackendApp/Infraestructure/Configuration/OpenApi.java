package Oncredit.BackendApp.Infraestructure.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Gestor de tareas", version = "1.0", description = "Documentación api de administración de Tareas"))
public class OpenApi {
}
