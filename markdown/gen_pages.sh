outDir="./"

# Generating HTML
for f in ./markdown/*.md
do
 echo "Processing $f"
 filename=$(basename "$f")
 filename="${filename%.*}"
 filename="$outDir$filename.html"

 echo "Writing to $filename"
 pandoc $f -o $filename
done