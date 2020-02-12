# base image
FROM node:latest as node
WORKDIR /usr/src/app
COPY . .

RUN npm install
RUN npm run build --prod


FROM nginx:alpine
## Remove default nginx website
RUN rm -rf /usr/share/nginx/html/*
## From 'builder' copy website to default nginx public folder
COPY --from=node /usr/src/app/dist/portMaster /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
