import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profissionals_matule.R

@Composable
fun SearchBar() {
    var query by remember { mutableStateOf("") }

    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = query,
            onValueChange = { query = it },
            modifier = Modifier
                .width(269.dp) // Сделали уже
                .height(52.dp)
                .shadow(2.dp, shape = RoundedCornerShape(14.dp)) // Добавили тень
                .clip(RoundedCornerShape(14.dp))
                .background(Color.White) // Фон белый для видимости тени
                .padding(horizontal = 8.dp),
            label = { Text("Поиск") },
            leadingIcon = {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.search),
                    contentDescription = "Search",
                    modifier = Modifier.padding(start = 10.dp)
                )
            },
            placeholder = { Text("Search...") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        Spacer(modifier = Modifier.size(5.dp))
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.filter),
            contentDescription = "Filter",
            modifier = Modifier.size(60.dp)
        )
    }
}

@Preview
@Composable
fun PreviewSearchBar() {
    SearchBar()
}
