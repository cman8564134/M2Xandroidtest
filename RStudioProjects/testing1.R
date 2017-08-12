#Fever patient
#install.packages("ggmap")
#library(devtools)
#install_version("ggplot2", version = "2.1.0", repos = "http://cran.us.r-project.org")

require(ggmap)
map<-get_map(location='Petaling Jaya', zoom=11, maptype = "terrain",
             source='google',color='bw')

# plot it with ggplot2
require(ggplot2)
ggmap(map) + geom_point(
  aes(x=long, y=lat, show_guide = TRUE, color=type,size=3), 
  data=combined, alpha=.5, na.rm = T, )  + 
  scale_color_gradient(low="white", high="blue")



#temperature
require(ggmap)
map<-get_map(location='Petaling Jaya', zoom=12, maptype = "terrain",
             source='google',color='bw')

# plot it with ggplot2
require(ggplot2)
ggmap(map) + geom_point(
  aes(x=long, y=lat, show_guide = TRUE, color=Degree,size=2), 
  data=temperature, alpha=.5, na.rm = T, )  + 
  scale_color_gradient(low="white", high="red")



#AQI
require(ggmap)
map<-get_map(location='Petaling Jaya', zoom=12.5, maptype = "terrain",
             source='google',color='colour')

# plot it with ggplot2
require(ggplot2)
ggmap(map) + geom_point(
  aes(x=long, y=lat, show_guide = TRUE, size=AQI), 
  data=AQI, alpha=.9, na.rm = T, )  + 
  scale_color_gradient(low="white", high="red")






