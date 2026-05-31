from PIL import Image
from pathlib import Path
import os

files = list(Path("./").glob("*.png"))

# for file in files:
#     img = Image.new(mode="RGBA", size=(16, 16), color=(0, 0, 0, 0))
#     foreground = Image.open(file)
#     img.paste(foreground, (2, 2))
#     img.save("_" + str(file))

for file in files:
    filename = str(file)
    newFile = filename[1:-5] + str(int(filename[-5]) - 1) + ".png"
    os.rename(filename, newFile)