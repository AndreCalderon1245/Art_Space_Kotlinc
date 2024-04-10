import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.R

// Definimos las imágenes adicionales
val imageResources = listOf(
    R.drawable.obra_de_arte_uno,
    R.drawable.obra_de_arte_dos,
    R.drawable.obra_de_arte_tres
)

// Definimos los títulos y autores correspondientes a cada imagen
val titles = listOf(
    "Interchange",
    "El aquelarre",
    "Klimt"
)

val authors = listOf(
    "Willem de Kooning(1955)",
    "Francisco de Goya(1797-1798)",
    "Gustav Klimt Austria(1862-1918)"
)

@Composable
fun ArtSpaceContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray) // Cambiar el color de fondo de la aplicación
    ) {
        ArtSpace()
    }
}

@Composable
fun ArtSpace() {
    // Estado para almacenar el índice de la imagen actual
    var currentIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp) // Agregar relleno alrededor del marco
        ) {
            Box(
                modifier = Modifier
                    .height(450.dp)
                    .width(300.dp)
                    .padding(top = 50.dp) // Padding específico en la parte superior del marco
                    .shadow(10.dp)
                    .background(Color(0xFF8B4513)) // Color madera
                    .border(2.dp, Color(0xFF8B4513), shape = RoundedCornerShape(8.dp)) // Borde color madera
                    .align(Alignment.Center)
            ) {
                Image(
                    painter = painterResource(id = imageResources[currentIndex]),
                    contentDescription = null,
                    modifier = Modifier
                        .size(350.dp) // Tamaño específico de la imagen dentro del marco
                        .align(Alignment.Center) // Centrar la imagen dentro del marco
                )
            }
        }
        Box(
            modifier = Modifier
                .width(400.dp)
                .padding(16.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFFFD700), Color(0xFFFFD700), Color(0xFFDAA520)),
                        start = Offset(0f, 0f),
                        end = Offset(100f, 100f)
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 16.dp, vertical = 8.dp) // Agregar margen al cuadro de texto
                .align(Alignment.CenterHorizontally)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = titles[currentIndex],
                    fontSize = 20.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(
                    text = authors[currentIndex],
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold, // Agregar negritas
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                // Mostrar la imagen anterior en la lista
                currentIndex = (currentIndex - 1 + imageResources.size) % imageResources.size
            }) {
                Text(text = "Previous")
            }
            Button(onClick = {
                // Mostrar la siguiente imagen en la lista
                currentIndex = (currentIndex + 1) % imageResources.size
            }) {
                Text(text = "Next")
            }
        }
    }
}
