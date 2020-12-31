# STAGE 1
FROM node:15-alpine AS builder
WORKDIR /app
COPY package.json ./
RUN yarn  install
COPY . /app
RUN yarn build

# STAGE 2
FROM nginx
COPY --from=builder /app/build /usr/share/nginx/html
EXPOSE 3000
CMD ["nginx", "-g", "daemon off;"]